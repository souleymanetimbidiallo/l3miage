#install.packages('FactoMineR')
#install.packages('cluster')
library(cluster)
library(FactoMineR)

tel = read.table("tel1984.txt", row.names=1, header=T, dec=",")
tel
help(kmeans)
resclus = kmeans(tel[,1:7], 4, algorithm = "Lloyd") # on ne s'occupe pas de la 8eme colonne

resclus 

resclus$cluster #numeros des groupes de chaque individu

resclus$centers #barycentre de chaque groupe.

resclus$withinss #inertie intra-classe de chaque groupe. 
resclus$tot.withinss #inertie intra-totale

resclus$size #le nombre d'individus de chaque groupe.

#Examen des resultats d'analyse 1

plot(tel$igqs, tel$ezaa, col=resclus$cluster)

tel = cbind(tel, as.factor(resclus$cluster))
colnames(tel)[9] = "Classe km"
tel

catdes(tel[, c(1:7, 9)], num.var = 8) #on selectionne les variables descriptives (colonne 1 à 7, puis la colonne des classes, ie 9)
resclus$cluster

tel_acp = PCA(tel[,c(1:7,8)], quali.sup = 8)

tel_acp$eig

resclusnorm = kmeans(scale(tel[, 1:7]), 4, algorithm = "Lloyd")

resclusnorm$withinss

resclusnorm$size
plot(tel$igqs, tel$ezaa, col=resclusnorm$cluster)
tel = cbind(tel, as.factor(resclusnorm$cluster))
colnames(tel)[10] = "Classe km"
tel
catdes(tel[, c(1:7, 10)], num.var = 8) #on selectionne les variables descriptives (colonne 1 à 7, puis la colonne des classes, ie 9)

#2 CAH
rescah = agnes(scale(tel[, 1:7]), method="ward")
plot(rescah, xlab="regions")

rescahmin = agnes(scale(tel[, 1:7]), method="single")
rescahmin
plot(rescahmin)


rescahmax = agnes(scale(tel[, 1:7]), method="complete")
rescahmax
plot(rescahmax)

numclassward=cutree(rescah, k=4)
numclassward
numclassmax = cutree(rescahmax, k=4)
numclassmax
table(numclassward, numclassmax)

#Faire le premier plan factoriel du TD3


