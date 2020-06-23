package com.eaiesb.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection ="Sequences")
public class Sequences {
	
	@Id
	private String seqName;
	private long sequence;
	public String getSeqName() {
		return seqName;
	}
	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}
	public long getSequence() {
		return sequence;
	}
	public void setSequence(long sequence) {
		this.sequence = sequence;
	}
	public Sequences(String seqName, long sequence) {
		super();
		this.seqName = seqName;
		this.sequence = sequence;
	}

	


}
