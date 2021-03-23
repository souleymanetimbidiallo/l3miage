library(FactoMineR)
data(JO)
JO
#Oui, il y a bien un tableau de contingence

#les individus: les medailles obtenues aux épreuves des jeux olympiques.

# les variables associees: disciplines JO / pays

jeux = table(JO) #s fournie la distribution des valeurs dans les cellules
length(table(JO))
barplot(table(JO))#obtenir le graphique de la distribution

#le nombre de cellules contenant 0: 1211
#le pays qui a obtenu le plus grand nombre de m´edailles pour une ´epreuve particuliere:
which(JO==max(JO), arr.ind=T)
JO[7, 31]
rownames(JO) #listes des epreuves
colnames(JO) #listes des pays
colnames(JO)[37]

#le nombre de m´edailles obtenues par les pays
rev(sort(apply(JO,2,sum)))




#AFC
resca = CA(JO)
resca
round(resca$eig,2)
#Faites un graphique des valeurs propres
barplot(resca$eig[,1],names.arg = c(1:23))

#Nombre d’axes sont necessaires pour representer tous 
#les profils-lignes et colonnes sans perte d’inertie: 23 axes.

Nombre d’axes a conserver pour analyser ces donnees: 
#sommes des (eigenvalue) / 23 => 1/23 => on a 4%, on choisi
#alors toutes les val propres dont le pourcentage de variance est supérieure
#ou egal à 4 => Donc nous avons 10 axes. 

#Pourcentage d’inertie exprimee sur le premier plan factoriel: 
plot(resca, axes=1:2)
plot(resca,axes=3:4)
resca$row
resca$col