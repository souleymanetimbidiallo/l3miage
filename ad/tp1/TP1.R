#EXERCICE 1

tabac = read.table("tabac.txt", header = T, row.names = 1)
tabac

tabac$Vente
tabac$Prix

mean(tabac$Vente)
mean(tabac$Prix)

cor(tabac$Prix, tabac$Vente)^2
plot(tabac$Prix,tabac$Vente) # trace simple
plot(tabac$Prix,tabac$Vente, main="Consommation de tabac en France",col="blue",lwd=2,xlab="Prix relatif de vente (en euros)",ylab="Nombre de cigarettes vendues (en milliards)")

reg = lm(Vente~Prix, data = tabac)
reg
reg$coefficients
abline(reg, col="red")
summary(reg)

reg$residuals
round(reg$residuals,3)
round(reg$residuals,3)[16]

reg$fitted.values

SCEr = sum(reg$residuals^2)
SCEr
SCEt = sum((tabac$Vente - mean(tabac$Vente))^2)
SCEt
SCEm = SCEt - SCEr
SCEm

summary(reg)$r.squared

summary(reg)$sigma^2
varResidu = SCEr/(length(tabac$Vente)-2)
varResidu

summary(reg)$coefficients

#On confirme que l'hypothèse H1 est valide: b!=0 et on refuse H0


tf = (SCEm/1)/(SCEr/(length(tabac$Vente)-2))
tf
summary(reg)$fstatistic


new = data.frame(288.3) # creation du nouvel individu avec sa valeur de Prix
colnames(new) = "Prix" # label de la variable explicative
predict(reg, new, interval = "confidence") # pour prediction moyenne

#EXERCICE 2:

mat<-read.table("materiau.txt",header=T)
mat
par(mfrow=c(2,2))
reg1 = lm(Y~X1, data=mat)
reg1
plot(mat$X1, mat$Y)
reg2 = lm(Y~X2, data=mat)
reg2
plot(mat$X2, mat$Y)

regmul<-lm(Y~X1+X2,data=mat) # on precise le nom des variables explicatives OU
regmulbis<-lm(Y~.,data=mat) # on prend toutes les variables autre que Y en utilisant
regmul
regmulbis
plot(mat)