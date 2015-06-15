	public static void main(String[] argv){
		
        ArrayList<Object> finalLists = new ArrayList<Object>();
        
        finalLists.add(0);
        
        ArrayList<Object> firstLevelList = new ArrayList<Object>();
        firstLevelList.add(1);
        firstLevelList.add(2);
        finalLists.add(firstLevelList);
        
        finalLists.add(3);
        
        firstLevelList = new ArrayList<Object>();
        finalLists.add(firstLevelList);
        
        firstLevelList = new ArrayList<Object>();
        firstLevelList.add(4);
        ArrayList<Object> secondLevelList = new ArrayList<Object>();
        secondLevelList.add(5);
        secondLevelList.add(6);
        firstLevelList.add(secondLevelList);
        finalLists.add(firstLevelList);
        
        System.out.print("The original Lists is --- > " + finalLists);
        DeepIterator test = new DeepIterator(finalLists);
        
        System.out.println();
        System.out.print("The flatten Lists is --- > ");
        while(test.hasNext()) {
            System.out.print(test.next() + " --> ");
        }
		
	}
