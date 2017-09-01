import struct
import sys
import time

if len(sys.argv) != 2:
    print "USO %s [CEP]" % sys.argv[0]
    quit()
 
registroCEP = struct.Struct("72s72s72s72s2s8s2s")
cepColumn = 5
t_ini = time.time()
f = open("cep_ordenado.dat","r")
line=f.read(registroCEP.size)

inicial=0
meio=0
encontrado = False
end =['Endereco','Bairro','Cidade','Estado','Sigla','CEP']
vet=[]

while line!="":
    #Criacao de um vetor contendo todos os CEP's do arquivo
    record=registroCEP.unpack(line)
    vet.append(record[5])
    line=f.read(registroCEP.size)

final=len(vet)-1
contador=0
#Algoritmo de busca binaria
while encontrado==False:
	contador=contador+1
	meio=int((inicial+final)/2)
	
	if vet[meio] == sys.argv[1]:
		encontrado=True
		tamanho=(meio+1)*registroCEP.size
		f.seek(tamanho-registroCEP.size)
		text=f.readline(registroCEP.size)
		dados=registroCEP.unpack(text)
		for i in range(0,len(dados)-1):
			if(dados[i] != " "):
				print end[i] + ':' + dados[i].strip().decode('latin1')  
			     
	elif inicial > final:
		print 'CEP NAO ENCONTRADO'
		break
		
	if vet[meio] > sys.argv[1]: 
		final=meio-1
		
	else:
		inicial=meio+1
 	

t_fim=time.time()	
print "Tempo de Execucao:",round(t_fim- t_ini,4),'segundos'
print "Numero de passos:",contador


f.close()
