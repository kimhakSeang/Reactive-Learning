package com.java.reactive.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FileUtil {
		private final static Path path = Paths.get("src/main/resources");
		
		public static Mono<String> FileReader(String fileName) {
			return Mono.fromSupplier(()-> {
				try {
					System.out.println("--------------<Read Data>--------------");
					return Files.readString(path.resolve(fileName));
				} catch (Exception e) {
					throw new RuntimeException("File can't read!");
				} 
			});
		}
	
		public static Mono<String> fileWriter(String fileName, String letter) {
			return Mono.fromSupplier(() -> {
					try {
						System.out.println("--------------<Write Data>--------------\nStart writing: "+letter);
						FileWriter fileWriter = new FileWriter(path.resolve(fileName).toString());
						fileWriter.write(letter);
						fileWriter.close();
						return "Done";
					} catch (IOException e) {
						throw new RuntimeException("Error while writing data!");
					}
				}
			);
		}
		public static Mono<String> deleteFile(String fileName) {
			return Mono.fromSupplier(() -> {
				System.out.println("-------------<Delete File>-------------");
				File file = new File(path.resolve(fileName).toString());
				file.delete();
				return "Done";
			});
		}
		
}
