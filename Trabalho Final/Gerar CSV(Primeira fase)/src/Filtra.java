import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Filtra {
	public static void main(String[] args) throws IOException {
		Filtra.geraCSV2013();
		Filtra.geraCSV2014();
		
	}
	
	public static void geraCSV2013() throws IOException{
		estado=estado.toUpperCase();
		long tempoInicial = System.currentTimeMillis();
		String arquivo="MICRODADOS_ENEM_2014.csv";
		BufferedReader br =null;
		String linha="";
		FileOutputStream arq = new FileOutputStream (new File("DadosAlunos2014.csv"));
		String nota1,nota2,nota3,nota4,nota5 = null;
		int cont=0;
		try{
			System.out.println("oi1");
			br= new BufferedReader(new FileReader(arquivo));
			System.out.println("oi2");
			while((linha= br.readLine())!= null){	
				
				String [] div = linha.split(",");
				
				
				if (div.length==166){
				for(int i=0;i<div.length;i++)	
				{
						  //Configuracao para deixar tabulacao dos dados correta
						  int x= 150 - div[3].trim().length();
						  int y= 8 - div[96].trim().length(),y1= 8 - div[97].trim().length();
						  int y2= 8 - div[98].trim().length(),y3= 8 - div[99].trim().length();
						  int y1000= (6 - div[115].trim().length());//5
						  String help="",help1="",help2="",help3="",help4="",help1000="";
						  
						  for(int j=0;j<x;j++){
							  help+=" ";
						  }
						  if(y<6){
							  for(int j=0;j<y;j++){
								  help1+=" ";
							  }
						  }if(y1<6){
							  for(int j=0;j<y1;j++){
								  help2+=" ";
							  }
						  }if(y2<6){
							  for(int j=0;j<y2;j++){
								  help3+=" ";
							  }
						  }if(y3<6){
							  for(int j=0;j<y3;j++){
								  help4+=" ";
							  }
						  }
						  
						 
						  if(div[96].trim().equals("0") || div[96].trim().equals("")){
							  nota1="000.0   ";
						  }else{
							  nota1=div[96].trim();
						  }
						  
						  if(div[97].trim().equals("0") || div[97].trim().equals("")){
							  nota2="000.0   ";
						  }else{
							  nota2=div[97].trim();
						  }
						  
						  if(div[98].trim().equals("0") || div[98].trim().equals("")){
							  nota3="000.0   ";
						  }else{
							  nota3=div[98].trim();
						  }
						  
						  if(div[99].trim().equals("0") || div[99].trim().equals("")){
							  nota4="000.0   ";
						  }else{
							  nota4=div[99].trim();
						  }
						 
						  
						  if(div[109].trim().equals("")){
							  div[109]="0";
						  }else{
							  div[109]=div[109].trim();
						  }
						  
						  if(div[110].trim().equals("") || div[110].trim().equals("0")){
							  div[110]="0";
						  }else{
							  div[110]=div[110].trim();
						  }
						  
						  if(div[111].trim().equals("") || div[111].trim().equals("0")){
							  div[111]="0";
						  }else{
							  div[111]=div[111].trim();
						  }
						  
						  if(div[112].trim().equals("") || div[112].trim().equals("0")){
							  div[112]="0";
						  }else{
							  div[112]=div[112].trim();
						  }
						  
						  if(div[113].trim().equals("") || div[113].trim().equals("0")){
							  div[113]="0";
						  }else{
							  div[113]=div[113].trim();
						  }
						  
						  if(div[114].trim().equals("") || div[114].trim().equals("0")){
							  div[114]="0";
						  }else{
							  div[114]=div[114].trim();
						  }
						  
						  if(div[115].trim().equals("")){
							  nota5="0     ";
						  }else{
							  nota5=div[115].trim();
						  }
						  
						  
						  if(div[88].trim().equals("")){
							  div[88]="0   ";
						  }else{
							  div[88]=div[88].trim();
						  }
						  if(div[89].trim().equals("")){
							  div[89]="0   ";
						  }else{
							  div[89]=div[89].trim();
						  }
						  if(div[90].trim().equals("")){
							  div[90]="0   ";
						  }else{
							  div[90]=div[90].trim();
						  }
						  if(div[91].trim().equals("")){
							  div[91]="0   ";
						  }else{
							  div[91]=div[91].trim();
						  }
						  
						  
						  if(y1000==3){
						  for(int k=0;k<y1000;k++){
							   help1000+=" ";
						  }
						  }else if(y1000==5 || y1000==4){
							  for(int k=0;k<3;k++){
								   help1000+=" ";
							  }
						  }else if(y1000==2){
							  for(int k=0;k<2;k++){
								   help1000+=" ";
							  }
						  }
						  
						  System.setOut(new PrintStream(arq));
						  System.out.format("%s   %-3s   %-3s"+help+"%-3s   %-3s   %-3s"
						  	+ "   %-3s   %-3s   %-3s   %-3s   "
						  	+ "%-3s   %-3s   %-3s   %-3s    %-3s   %-3s   %-3s  "
						  	+ " %-3s"+help1+"   %-3s"+help2+"   %-3s"+help3+"   %-3s"+help4+"   %-3s   %-3s   %-3s   %-3s  "
						  	+ " %-3s   %-3s   %-3s   %-3s"+help1000+"\n", div[0].toString(), div[2].toString(), div[3].trim(),div[5].trim(),
						  div[14].trim(),div[16].trim(),div[17].trim(),div[23].trim(),div[28].trim(),div[88].trim(),div[89].trim(),div[90].trim(),div[91].trim(),div[92].trim()
						  ,div[93].trim(),div[94].trim(),div[95].trim(),nota1,nota2,nota3,nota4,div[104].trim()
						  ,div[109].trim(),div[110].trim(),div[111].trim(),div[112].trim(),div[113].trim(),div[114].trim(),nota5);
						  break;
						
					
				}
			}
		}
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		System.out.println("CSV2014 gerado!!");
		System.out.println("o metodo executou em " + (System.currentTimeMillis() - tempoInicial)+" ms");
		arq.close();
		
		}catch(Exception e){
			
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			System.out.println("Erro na leitura do arquivo");
		}
		

	}
	public  void geraCSVEstado2014(String estado) throws IOException{
		estado=estado.toUpperCase();
		long tempoInicial = System.currentTimeMillis();
		String arquivo="MICRODADOS_ENEM_2013.csv";
		BufferedReader br =null;
		String linha="";
		FileOutputStream arq = new FileOutputStream (new File("DadosAlunos2013.csv"));
		String nota1,nota2,nota3,nota4,nota5 = null;
		int cont=0;
		try{
			System.out.println("oi1");
			br= new BufferedReader(new FileReader(arquivo));
			System.out.println("oi2");
			while((linha= br.readLine())!= null){	
				
				String [] div = linha.split(";");
				
				if (div.length==166 || div.length==143 || div.length==29){
				for(int i=0;i<div.length;i++)	
				{
						  int x= 150 - div[3].trim().length();
						  int y= 8 - div[70].trim().length(),y1= 8 - div[71].trim().length();
						  int y2= 8 - div[72].trim().length(),y3= 8 - div[73].trim().length();
						  int y1000= (6 - div[89].trim().length());//5
						  String help="",help1="",help2="",help3="",help4="",help1000="";
						  
						  for(int j=0;j<x;j++){
							  help+=" ";
						  }
						  if(y<6){
							  for(int j=0;j<y;j++){
								  help1+=" ";
							  }
						  }if(y1<6){
							  for(int j=0;j<y1;j++){
								  help2+=" ";
							  }
						  }if(y2<6){
							  for(int j=0;j<y2;j++){
								  help3+=" ";
							  }
						  }if(y3<6){
							  for(int j=0;j<y3;j++){
								  help4+=" ";
							  }
						  }
						  
						
						  if(div[70].trim().equals("0") || div[70].trim().equals("")){
							  nota1="000.0   ";
						  }else{
							  nota1=div[70].trim();
						  }
						  
						  if(div[71].trim().equals("0") || div[71].trim().equals("")){
							  nota2="000.0   ";
						  }else{
							  nota2=div[71].trim();
						  }
						  
						  if(div[72].trim().equals("0") || div[72].trim().equals("")){
							  nota3="000.0   ";
						  }else{
							  nota3=div[72].trim();
						  }
						  
						  if(div[73].trim().equals("0") || div[73].trim().equals("")){
							  nota4="000.0   ";
						  }else{
							  nota4=div[73].trim();
						  }
						 
						  
						  if(div[83].trim().equals("")){
							  div[83]="0";
						  }else{
							  div[83]=div[83].trim();
						  }
						  
						  if(div[84].trim().equals("") || div[84].trim().equals("0")){
							  div[84]="0";
						  }else{
							  div[84]=div[84].trim();
						  }
						  
						  if(div[85].trim().equals("") || div[85].trim().equals("0")){
							  div[85]="0";
						  }else{
							  div[85]=div[85].trim();
						  }
						  
						  if(div[86].trim().equals("") || div[86].trim().equals("0")){
							  div[86]="0";
						  }else{
							  div[86]=div[86].trim();
						  }
						  
						  if(div[87].trim().equals("") || div[87].trim().equals("0")){
							  div[87]="0";
						  }else{
							  div[87]=div[87].trim();
						  }
						  
						  if(div[88].trim().equals("") || div[88].trim().equals("0")){
							  div[88]="0";
						  }else{
							  div[88]=div[88].trim();
						  }
						  
						  if(div[89].trim().equals("")){
							  nota5="0     ";
						  }else{
							  nota5=div[89].trim();
						  }
						  
						  
						  if(div[62].trim().equals("")){
							  div[62]="0   ";
						  }else{
							  div[62]=div[62].trim();
						  }
						  if(div[63].trim().equals("")){
							  div[63]="0   ";
						  }else{
							  div[63]=div[63].trim();
						  }
						  if(div[64].trim().equals("")){
							  div[64]="0   ";
						  }else{
							  div[64]=div[64].trim();
						  }
						  if(div[65].trim().equals("")){
							  div[65]="0   ";
						  }else{
							  div[65]=div[65].trim();
						  }
						  
						  
						  if(y1000==3){
						  for(int k=0;k<y1000;k++){
							   help1000+=" ";
						  }
						  }else if(y1000==5 || y1000==4){
							  for(int k=0;k<3;k++){
								   help1000+=" ";
							  }
						  }else if(y1000==2){
							  for(int k=0;k<2;k++){
								   help1000+=" ";
							  }
						  }
						  
						  
						  System.setOut(new PrintStream(arq));
						  System.out.format("%s   %-3s   %-3s"+help+"%-3s   %-3s   %-3s"
						  	+ "   %-3s   %-3s   %-3s   %-3s   "
						  	+ "%-3s   %-3s   %-3s   %-3s    %-3s   %-3s   %-3s  "
						  	+ " %-3s"+help1+"   %-3s"+help2+"   %-3s"+help3+"   %-3s"+help4+"   %-3s   %-3s   %-3s   %-3s  "
						  	+ " %-3s   %-3s   %-3s   %-3s"+help1000+"\n", div[0].toString(), div[2].toString(), div[3].trim(),div[5].trim(),
						  div[13].trim(),div[15].trim(),div[16].trim(),div[22].trim(),div[27].trim(),div[62].trim(),div[63].trim(),div[64].trim(),div[65].trim(),div[66].trim()
						  ,div[67].trim(),div[68].trim(),div[69].trim(),nota1,nota2,nota3,nota4,div[78].trim()
						  ,div[83].trim(),div[84].trim(),div[85].trim(),div[86].trim(),div[87].trim(),div[88].trim(),nota5);
						  break;
						}
				
				}
				
			}
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		System.out.println("CSV2013 gerado!!");
		System.out.println("o metodo executou em " + (System.currentTimeMillis() - tempoInicial)+" ms");
		arq.close();
		
		}catch(Exception e){
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			System.out.println("Erro na leitura do arquivo");
		}
		

	}
		
		
}
