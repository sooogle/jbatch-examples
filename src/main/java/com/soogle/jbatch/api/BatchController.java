package com.soogle.jbatch.api;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/batch")
public class BatchController {
	
	@GET
	@Path("start/{name}")
	public long start(@PathParam("name") String name) {
		JobOperator ope = BatchRuntime.getJobOperator();
		return ope.start(name, null);
	}
	
	@GET
	@Path("restart/{id}")
	public long restart(@PathParam("id") long id) {
		JobOperator ope = BatchRuntime.getJobOperator();
		return ope.restart(id, null);
	}
	
}
