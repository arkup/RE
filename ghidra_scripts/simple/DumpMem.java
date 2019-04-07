//Simple script to dump database bytes to a file
//@author 
//@category _NEW_
//@keybinding 
//@menupath 
//@toolbar 

import ghidra.app.script.GhidraScript;
import ghidra.program.model.util.*;
import ghidra.program.model.reloc.*;
import ghidra.program.model.data.*;
import ghidra.program.model.block.*;
import ghidra.program.model.symbol.*;
import ghidra.program.model.scalar.*;
import ghidra.program.model.mem.*;
import ghidra.program.model.listing.*;
import ghidra.program.model.lang.*;
import ghidra.program.model.pcode.*;
import ghidra.program.model.address.*;

import java.io.FileOutputStream;
import java.lang.String;

public class DumpMem extends GhidraScript {

    public void run() throws Exception {

    	Address beginAddr = askAddress("DumpMem", "Start address?");
    	Address endAddr = askAddress("DumpMem", "End address?");
    	if (beginAddr.getOffset() > endAddr.getOffset())
    	{
    		println("Wrong end address");
    		return;
    	}
    	
    	String fileName = askString("DumpMem", "File to save to?");
    	println("Dumping bytes to: " + fileName);
    	
    	FileOutputStream outputStream = new FileOutputStream(fileName);
    	
    	Address currAddr = beginAddr;
    	while (currAddr.getOffset() < endAddr.getOffset())
    	{
    		byte b = getByte(currAddr);
    		outputStream.write(b);
    		currAddr = currAddr.add(1);
    	}
        outputStream.close();
    }

}
