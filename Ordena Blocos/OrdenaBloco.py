import struct 
import os
import time
import sys

def getKey(item):
	return item[0]

def getPos(item):
	return item[1]

tam_registros=0
if len(sys.argv) != 2:
	print "Como nao foi enviado o tamanho do registro para leitura, o default sera 10000"
	tam_registros=10000
elif len(sys.argv)==2:
	tam_registros=int (sys.argv[1])
inicio = time.time()
registroCEP = struct.Struct("72s72s72s72s2s8s2s")
f = open("cep.dat","r")
a = open("cep_blocos.dat","w+")
vet_blocos=[]

tam_blocos=tam_registros*registroCEP.size
f.seek(0,os.SEEK_END)
tam_arq=f.tell()
f.seek(0)
num_blocos=tam_arq//tam_blocos
resto = tam_arq%tam_blocos
vet_blocos=[tam_blocos]*num_blocos
if(resto>0):
	temResto=True
	vet_blocos.append(resto)

paraSempre=True

for i in range(len(vet_blocos)):#A cada bloco roda um loop
	j=0
	cont_linha=0
	lista=[]
	while paraSempre:
		line= f.readline(registroCEP.size)
		cont_linha=cont_linha + len(line)
		f.seek(f.tell()-1)#Vai para o 300 ao inves de 301
		if(len(line)!=300):
			break
		record=registroCEP.unpack(line)
		if(i==len(vet_blocos)-1 and vet_blocos[i]==cont_linha):#Verifica se o ultimo elemento do ultimo bloco(resto)
			lista[j:j]=[(record[5],f.tell()+1)]
		else:
			lista[j:j]=[(record[5],f.tell())]
		j=j+1
		if(vet_blocos[i]==cont_linha):#Se a quantidade de linhas e igual ao tamanho do bloco
			break

	lista_ord= sorted(lista,key=getKey)
	
	for k in range(len(lista_ord)):
	
		f.seek(lista_ord[k][1]-300)#Vou para onde o inicio onde o registro esta
		line= f.read(registroCEP.size)#Leitura da linha
		a.write(line)#escrevo no outro arquivo
		
	f.seek((((registroCEP.size*tam_registros)*(i+2)) - ((registroCEP.size)*(tam_registros))))#indo para a primeira posicao do proximo bloco

fim = time.time()
print "Tempo de execucao: "+str(round(fim-inicio,2))+"s"
