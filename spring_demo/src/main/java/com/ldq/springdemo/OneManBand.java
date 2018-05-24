package com.ldq.springdemo;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class OneManBand implements Performer{

	public OneManBand() {
	}
	
	private Collection<Instrument> instrumentCollection;
	private List<Instrument> instrumentList;
	private Instrument[] instrumentArray;
	private Map<String, Instrument> instrumentMap;
	private Properties instrumentProps;
	
	public void setInstrumentCollection(Collection<Instrument> instrumentCollection) {
		this.instrumentCollection = instrumentCollection;
	}

	public void setInstrumentList(List<Instrument> instrumentList) {
		this.instrumentList = instrumentList;
	}

	public void setInstrumentArray(Instrument[] instrumentArray) {
		this.instrumentArray = instrumentArray;
	}

	public void setInstrumentMap(Map<String, Instrument> instrumentMap) {
		this.instrumentMap = instrumentMap;
	}

	public void setInstrumentProps(Properties instrumentProps) {
		this.instrumentProps = instrumentProps;
	}
	
	@Override
	public void perform() {
		System.out.println("+++++++Collection+++++++");
		for(Instrument instrument: instrumentCollection){
			System.out.println("现在是"+ instrument + "正在演奏...");
		}
		System.out.println("+++++++List+++++++");
		for(Instrument instrument: instrumentList){
			System.out.println("现在是"+ instrument + "正在演奏...");
		}
		System.out.println("+++++++Array+++++++");
		for(Instrument instrument: instrumentArray){
			System.out.println("现在是"+ instrument + "正在演奏...");
		}
		System.out.println("+++++++Map+++++++");
		for(Instrument instrument: instrumentMap.values()){
			System.out.println("现在是"+ instrument + "正在演奏...");
		}
		System.out.println("+++++++Props+++++++");
		for(Object obj : instrumentProps.keySet()){
			System.out.println("现在是"+ obj + "正在演奏...");
		}
	}

	@Override
	public void perform(String str) {
		// TODO Auto-generated method stub
		
	}

}
