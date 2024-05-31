package com.java.reactive.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import reactor.core.publisher.Flux;

public class FluxFile {
	private final static Path path = Paths.get("src/main/resources");
	public static void main(String[] args) {
		Flux.generate(()-> 1, (count, sink)->{
			try {
				System.out.println("--------------<Read Data>--------------");
				Files.readString(path.resolve("FileData.txt"));
			} catch (Exception e) {
				throw new RuntimeException("File can't read!");
			} 
			
			
			return count + 1;
		});
	}

}
