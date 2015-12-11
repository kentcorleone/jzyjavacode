public   static  void  main (String[] args)
    {
        // TODO Auto-generated method stub
                   try
                   {
                   FileReader fr=new FileReader("yiban_report.txt");
                   BufferedReader b=new BufferedReader(fr);
                   String line= null;
                   while ((line =b.readLine())!= null) //按行读取
                   {   
                    String arr = line.trim();
                    String hz="[\u4e00-\u9fa5]";
                       Pattern p = Pattern.compile(hz);
                       Matcher s =p.matcher(line);
                       boolean c=s.find();
                       if(c)
                       {  
                        FileWriter fw = null;
                        File f = new File("new.txt");
                        try 
                        {
                        if(!f.exists())
                        {
                        f.createNewFile();
                        }
                        fw = new FileWriter(f);
                        BufferedWriter out = new BufferedWriter(fw);
                        out.write(arr, 0, arr.length()-1);
                        out.close();
                        }
                        catch (IOException e)
                        {
                        e.printStackTrace();
                        }
                       }
                   }
                   }
                   catch (IOException e)
                   {
                       e.printStackTrace();
                   }   

}
}