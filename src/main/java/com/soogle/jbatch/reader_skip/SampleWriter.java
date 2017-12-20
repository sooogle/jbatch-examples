package com.soogle.jbatch.reader_skip;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.batch.api.chunk.ItemWriter;

public class SampleWriter implements ItemWriter {
	
	@Override
	public Serializable checkpointInfo() throws Exception {
		System.out.println("[Writer] checkpointInfo.");
		return null;
	}

	@Override
	public void close() throws Exception {
		System.out.println("[Writer] close");
	}

	@Override
	public void open(Serializable arg0) throws Exception {
		System.out.println("[Writer] open");		
	}

	@Override
	public void writeItems(List<Object> arg0) throws Exception {
		List<String> items = arg0.stream().map(String::valueOf).collect(Collectors.toList());
		System.out.println("[Writer] writeItems: " + String.join(",", items));
	}
}
