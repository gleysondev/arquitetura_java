package aulas.utils;

import java.io.File;

public class FileStorage {
	public static File storage() {
		File diretorio =new File("/temp/storage");
		if(!diretorio.exists())
			diretorio.mkdirs();
		return diretorio;
	}
}
