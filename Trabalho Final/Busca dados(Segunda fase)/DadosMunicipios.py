# -*- coding: utf-8 -*-
import struct
import sys
import time
import operator
from unicodedata import normalize 
import locale

registroENEM = struct.Struct("15s10s150s12s7s6s6s6s6s6s6s6s6s6s6s6s11s11s11s11s6s6s6s6s6s6s6s7s")
registroENEM2 = struct.Struct("15s10s150s12s7s6s6s6s6s6s6s6s6s6s6s6s11s11s11s11s6s6s6s6s6s6s6s7s");
print(registroENEM.size)
f1 = open("DadosAlunos2013.csv","r")
f2 = open("DadosAlunos2014.csv","r")
dicReg1={}
dicReg2={}



def removeAcento(txt):

    return normalize('NFKD', txt.decode('latin-1')).encode('ASCII','ignore') 

	
def carregaDados():
	ini=time.time()
	f1.seek(572)
	f2.seek(588)
	line1=f1.read(registroENEM.size)
	line2=f2.read(registroENEM.size)

	while line1 != " " and line2!=" ":
		
		if(len(line1)<=352 or len(line2)<=352):
			break
			
		record1=registroENEM.unpack(line1)
		record2=registroENEM.unpack(line2)
		notas1=[record1[16].strip(),record1[17].strip(),record1[18].strip(),record1[19].strip(),record1[27].strip()]
		notas2=[record2[16].strip(),record2[17].strip(),record2[18].strip(),record2[19].strip(),record2[27].strip()]
		if(dicReg1.has_key(removeAcento(record1[2]).lower().strip())):
			list=dicReg1[removeAcento(record1[2]).lower().strip()]			
			dicReg1[removeAcento(record1[2]).lower().strip()]=list
			list.append(notas1)
		
		else:
			list=[]
			dicReg1[removeAcento(record1[2]).lower().strip()]=list
			list.append(notas1)
			
			
		if(dicReg2.has_key(removeAcento(record2[2]).lower().strip())):
			list=dicReg2[removeAcento(record2[2]).lower().strip()]
			dicReg2[removeAcento(record2[2]).lower().strip()]=list
			list.append(notas2)	
			
		else:
			list=[]
			dicReg2[removeAcento(record2[2]).lower().strip()]=list
			list.append(notas2)
		
		
		line1=f1.read(registroENEM.size)
		line2=f2.read(registroENEM.size)
	fim=time.time()
	print ("Tempo Exec:", round((fim-ini),2),"s")
	

	
def buscaNotaProva(municipio,media):
	ini=time.time()
	municipio=municipio.strip().lower()
	aumento=0
	contPassado=0
	contAtual=0
	contFuturo=0
	
	if(dicReg1.has_key(municipio)):
		list=dicReg1[municipio]

		
		for i in range(len(list)): 
			if(((float(list[i][0])+float(list[i][1])+float(list[i][2])+float(list[i][3]))/4) >= float(media)):
			
				contPassado=contPassado+1
		
			
	
	if( dicReg2.has_key(municipio)):
		list2=dicReg2[municipio]

		for j in range(len(list2)):	
			if(((float(list2[j][0])+float(list2[j][1])+float(list2[j][2])+float(list2[j][3]))/4) >= float(media)):
			
				contAtual=contAtual+1
			
			
	else:
		print "Estado nao encontrado, tente novamente"
		return 0
		
	
	aumento=round((float)((contAtual-contPassado)/float(contPassado)),5)
	contFuturo=contAtual*(1+aumento)
	print "Previsao de numero de alunos acima dessa media no proximo ano e :",int(contFuturo)," estudantes"
	fim=time.time()
	print ("Tempo Exec:", round((fim-ini),2),"s")


def BuscaNotaRedacao(municipio,notaRed):
	ini=time.time()
	municipio=municipio.strip().lower()
	aumento=0
	contPassado=0
	contAtual=0
	contFuturo=0
	
	if(dicReg1.has_key(municipio)):
		list=dicReg1[municipio]
		for i in range(len(list)): 
			if(int(list[i][4]) >= int(notaRed)):
			
				contPassado=contPassado+1
		
			
	
	if( dicReg2.has_key(municipio)):
		list2=dicReg2[municipio]
		for j in range(len(list2)):	
			if(int(list2[j][4]) >= int(notaRed)):
			
				contAtual=contAtual+1
			
			
	else:
		print "Estado nao encontrado, tente novamente"
		return 0
		

	aumento=round((float)((contAtual-contPassado)/float(contPassado)),5)
	contFuturo=contAtual*(1+aumento)
	
	print "Previsao de numero de alunos com as notas de redacao acima dessa no proximo ano e :",int(contFuturo)," estudantes"
	
	fim=time.time()
	print "Tempo Exec:", round((fim-ini),2),"s"
	
	
print ("Carregando dados, por favor aguarde")

carregaDados()

paraSempre=0

while paraSempre==0:
	municipio=raw_input("Digite o nome do municipio que voce quer filtrar os dados: ")
	opcao=input("Filtrar notas de redacao(1) ou provas das areas do conhecimento(2)? ")
	
	if(opcao==1):
		notaRed=raw_input("Digite a media que voce quer filtrar: ")
		
		BuscaNotaRedacao(municipio,notaRed)
		paraSempre=input("Digite 0 para continuar e digite 1 para sair: ")
		
	elif(opcao==2):
		media=raw_input("Digite a media que voce quer filtrar: ")
		buscaNotaProva(municipio,media)
		paraSempre=input("Digite 0 para continuar e digite 1 para sair: ")
	else:
		print 'Opcao invalida, tente novamente'
	