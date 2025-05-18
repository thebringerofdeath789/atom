package com.bea.xml.stream.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class SymbolTable {
    private int depth = 0;
    private Stack table = new Stack();
    private Map values = new HashMap();

    public void clear() {
        this.depth = 0;
        this.table.clear();
        this.values.clear();
    }

    public int getDepth() {
        return this.depth;
    }

    public boolean withinElement() {
        return this.depth > 0;
    }

    public void put(String str, String str2) {
        this.table.push(new Symbol(str, str2, this.depth));
        if (!this.values.containsKey(str)) {
            Stack stack = new Stack();
            stack.push(str2);
            this.values.put(str, stack);
            return;
        }
        ((Stack) this.values.get(str)).push(str2);
    }

    public String get(String str) {
        Stack stack = (Stack) this.values.get(str);
        if (stack == null || stack.isEmpty()) {
            return null;
        }
        return (String) stack.peek();
    }

    public Set getAll(String str) {
        HashSet hashSet = new HashSet();
        Iterator it = this.table.iterator();
        while (it.hasNext()) {
            Symbol symbol = (Symbol) it.next();
            if (str.equals(symbol.getName())) {
                hashSet.add(symbol.getValue());
            }
        }
        return hashSet;
    }

    public void openScope() {
        this.depth++;
    }

    public void closeScope() {
        int i = ((Symbol) this.table.peek()).depth;
        while (i == this.depth && !this.table.isEmpty()) {
            ((Stack) this.values.get(((Symbol) this.table.pop()).name)).pop();
            if (this.table.isEmpty()) {
                break;
            } else {
                i = ((Symbol) this.table.peek()).depth;
            }
        }
        this.depth--;
    }

    public String toString() {
        Iterator it = this.table.iterator();
        String str = "";
        while (it.hasNext()) {
            str = new StringBuffer().append(str).append((Symbol) it.next()).append("\n").toString();
        }
        return str;
    }

    public static void main(String[] strArr) throws Exception {
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.openScope();
        symbolTable.put("x", "foo");
        symbolTable.put("y", "bar");
        System.out.println(new StringBuffer().append("1 x:").append(symbolTable.get("x")).toString());
        System.out.println(new StringBuffer().append("1 y:").append(symbolTable.get("y")).toString());
        symbolTable.openScope();
        symbolTable.put("x", "bar");
        symbolTable.put("y", "foo");
        symbolTable.openScope();
        symbolTable.put("x", "barbie");
        symbolTable.openScope();
        symbolTable.closeScope();
        System.out.println(new StringBuffer().append("3 x:").append(symbolTable.get("x")).toString());
        symbolTable.closeScope();
        System.out.println(new StringBuffer().append("2 x:").append(symbolTable.get("x")).toString());
        System.out.println(new StringBuffer().append("2 y:").append(symbolTable.get("y")).toString());
        System.out.print(symbolTable);
        symbolTable.closeScope();
        System.out.println(new StringBuffer().append("1 x:").append(symbolTable.get("x")).toString());
        System.out.println(new StringBuffer().append("1 y:").append(symbolTable.get("y")).toString());
        symbolTable.closeScope();
        System.out.print(symbolTable);
    }
}