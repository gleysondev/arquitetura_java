package aulas.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.util.Tool;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.ToolRunner;

public class CovidApuracao implements Tool {

	@Override
	public Configuration getConf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConf(Configuration arg0) {
		// TODO Auto-generated method stub

	}
	//https://www.youtube.com/watch?v=mpCMUkf6WSQ
	@Override
	public int run(String[] args) throws Exception {
		if (args.length != 2) {
            System.err.printf("Usage: %s needs two arguments, input and output files\n", getClass().getSimpleName());
            return -1;
        }
		
		Job job = new Job();
        job.setJarByClass(CovidApuracao.class);
        job.setJobName("CovidApuracao");
         
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
     
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setOutputFormatClass(TextOutputFormat.class);
         
        job.setMapperClass(MapClass.class);
        job.setReducerClass(ReduceClass.class);
     
        int returnValue = job.waitForCompletion(true) ? 0:1;
         
        if(job.isSuccessful()) {
            System.out.println("Job was successful");
        } else if(!job.isSuccessful()) {
            System.out.println("Job was not successful");           
        }
         
        return returnValue;
		
	}

}
