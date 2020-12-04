package aulas.batch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.batch.api.chunk.ItemWriter;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import aulas.model.Cliente;
import aulas.model.Fatura;
import aulas.model.Lancamento;

@Dependent
@Named("GeraFaturasWriter")
public class GeraFaturasWriter implements ItemWriter {

       @PersistenceContext
       private EntityManager em;

       @Inject
       private JobContext contextoBatch;
       private FileWriter fileWriter;

       private NumberFormat formatadorNumero;
       private SimpleDateFormat formatadorDatas;
       private Cliente cliente;
       private Fatura fatura;

       private String TMP_DIR = System.getProperty("java.io.tmpdir");

       private Boolean aberto;
       
       @Inject
       private PropertiesService propertiesService;

       public GeraFaturasWriter() {
             formatadorNumero = DecimalFormat.getCurrencyInstance(new Locale("pt",
                           "BR"));
             formatadorDatas = new SimpleDateFormat("dd/MM/yyyy");
       }

       @Override
       public void open(Serializable checkpoint) throws Exception {
             cliente = getCliente();
             fatura = cliente.getFaturaAberta();

             File file = new File(TMP_DIR + File.separator + "/fatura-cliente-"
                           + cliente.getId() + ".txt");

             // Processo sendo reaberto após alguma interrupção no processo ou
             // primeira abertura
             aberto = checkpoint != null;
             fileWriter = new FileWriter(file, aberto);
             if (!aberto) {
                    escreveCabecalho();
             }
             aberto = true;
       }

       private void escreveCabecalho() throws IOException {
             String fechamentoFormatado = formatadorDatas.format(fatura
                           .getDataFechamento());
             fileWriter
                           .write("--------------------------------------------------\n");
             fileWriter.write("                  Cliente: " + cliente.getNome()
                           + "\n");
             fileWriter
                           .write("--------------------------------------------------\n");
             fileWriter.write("Fatura: " + fatura.getId() + " - fechamento:"
                           + fechamentoFormatado + "\n");
             fileWriter
                           .write("--------------------------------------------------\n");
       }

       @Override
       public void close() throws Exception {
             fileWriter
                           .write("--------------------------------------------------\n");
             fileWriter.close();
       }

       public void writeItems(List<Object> items) throws Exception {
             for (Object o : items) {
                    Lancamento lanc = (Lancamento) o;
                    String dataFormatada = formatadorDatas.format(lanc.getData());
                    String texto = lanc.getDescricao() + " - Valor: "
                                  + formatadorNumero.format(lanc.getValor()) + " - Data:"
                                  + dataFormatada + "\n";
                    fileWriter.write(texto);
                    em.merge(lanc);
             }
             fileWriter.flush();
             propertiesService.next();
       }

       @Override
       public Serializable checkpointInfo() throws Exception {
             return aberto;
       }
       
       /*
       private Cliente getCliente() {
             JobOperator jobOperator = BatchRuntime.getJobOperator();
             Properties propriedadesParticao = jobOperator
                           .getParameters(contextoBatch.getExecutionId());
             Long clienteId = (Long) propriedadesParticao.get("clienteId");
             return em.find(Cliente.class, clienteId);
       }
       */
       
       
       
       private Cliente getCliente() {
           Long clienteId = Long.valueOf(propertiesService.getValue());
           return em.find(Cliente.class, clienteId);
           
     }
}
