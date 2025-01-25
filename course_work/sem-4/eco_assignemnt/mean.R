# Eco Assignemnt_1_DHEERAJ_2020194 

dheeraj<-read.csv("D:/Desktop/main.csv")
#finding mean according to given assignment q 
#here na.rm is used to remove "NA" from mean data while finding mean
meanv40<- mean(dheeraj$v40 , na.rm=TRUE)
print(meanv40)

meanv42<- mean(dheeraj$v42 , na.rm=TRUE)
print(meanv42)

meanv43<- mean(dheeraj$v43 , na.rm=TRUE)
print(meanv43)

meanv44<- mean(dheeraj$v44 , na.rm=TRUE)
print(meanv44)

meanv45<- mean(dheeraj$v45 , na.rm=TRUE)
print(meanv45)

meanv46<- mean(dheeraj$v46 , na.rm=TRUE)
print(meanv46)

# now finding median

medianv40<- median(dheeraj$v40 , na.rm=TRUE)
print(medianv40)

medianv42<- median(dheeraj$v42 , na.rm=TRUE)
print(medianv42) 

medianv43<- median(dheeraj$v43 , na.rm=TRUE)
print(medianv43)

medianv44<- median(dheeraj$v44,na.rm=TRUE)
print(medianv44)

medianv45<- median(dheeraj$v45 , na.rm=TRUE)
print(medianv45)

medianv46<- median(dheeraj$v46 , na.rm=TRUE)
print(medianv46)

#finding mode


getmode = function(v) {
  uniqv = unique(v)
  uniqv[which.max(tabulate(match(v, uniqv)))]
}

v40 = dheeraj[,c('v40')]
v40 = as.data.frame(v40)
v40_mode = getmode(v40[1,])
print(v40_mode)

v42 = dheeraj[,c('v42')]
v42 = as.data.frame(v42)
v42_mode = getmode(v42[1,])
print(v42_mode)

v43 = dheeraj[,c('v43')]
v43 = as.data.frame(v43)
v43_mode = getmode(v43[1,])
print(v43_mode)

v44 = dheeraj[,c('v44')]
v44 = as.data.frame(v44)
v44_mode = getmode(v44[1,])
print(v44_mode)

v45 = dheeraj[,c('v45')]
v45 = as.data.frame(v45)
v45_mode = getmode(v45[1,])
print(v45_mode)
 
v46 = dheeraj[,c('v46')]
v46 = as.data.frame(v46)
v46_mode = getmode(v46[1,])
print(v46_mode)

#Standard Deviation

print(sd(dheeraj$v40,na.rm = TRUE))
print(sd(dheeraj$v42,na.rm = TRUE))
print(sd(dheeraj$v43,na.rm = TRUE))
print(sd(dheeraj$v44,na.rm = TRUE))
print(sd(dheeraj$v45,na.rm = TRUE))
print(sd(dheeraj$v46,na.rm = TRUE))

# Q2 part B
#importing ggplot to make histrogram
  
library(ggplot2)

v40 = dheeraj[,c('v40')]
v42 = dheeraj[,c('v42')]
v43 = dheeraj[,c('v43')]
v44 = dheeraj[,c('v44')]
v45 = dheeraj[,c('v45')]
v46 = dheeraj[,c('v46')]

#Year wise

ggplot(dheeraj,aes(v40,fill=as.factor(year)))+geom_histogram(alpha = 0.4,position="identity")
ggplot(dheeraj,aes(v42,fill=as.factor(year)))+geom_histogram(alpha = 0.4,position="identity")
ggplot(dheeraj,aes(v43,fill=as.factor(year)))+geom_histogram(alpha = 0.4,position="identity")
ggplot(dheeraj,aes(v44,fill=as.factor(year)))+geom_histogram(alpha = 0.4,position="identity")
ggplot(dheeraj,aes(v45,fill=as.factor(year)))+geom_histogram(alpha = 0.4,position="identity")
ggplot(dheeraj,aes(v46,fill=as.factor(year)))+geom_histogram(alpha = 0.4,position="identity")

#Season wise 

ggplot(dheeraj,aes(v40,fill=as.factor(season)))+geom_histogram(alpha = 0.4,position="identity")
ggplot(dheeraj,aes(v42,fill=as.factor(season)))+geom_histogram(alpha = 0.4,position="identity")
ggplot(dheeraj,aes(v43,fill=as.factor(season)))+geom_histogram(alpha = 0.4,position="identity")
ggplot(dheeraj,aes(v44,fill=as.factor(season)))+geom_histogram(alpha = 0.4,position="identity")
ggplot(dheeraj,aes(v45,fill=as.factor(season)))+geom_histogram(alpha = 0.4,position="identity")
ggplot(dheeraj,aes(v46,fill=as.factor(season)))+geom_histogram(alpha = 0.4,position="identity")

#Q 2) C )
#outliers in v40
boxplot(dheeraj$v40,horizontal = T)
outliers_v40<-dheeraj$v40[dheeraj$v40>20]
na.omit(outliers_v40)
boxplot(outliers_v40,horizontal  =T)

#outliers in v42
boxplot(dheeraj$v42,horizontal = T)
outliers_v42<-dheeraj$v42[dheeraj$v42>57]
na.omit(outliers_v42)
boxplot(outliers_v42,horizontal  =T)

#outliers in v43
boxplot(dheeraj$v43,horizontal = T)
outliers_v43<-dheeraj$v43[dheeraj$v43>20]
na.omit(outliers_v43)
boxplot(outliers_v43,horizontal  =T)

#outliers in v44 
boxplot(dheeraj$v44,horizontal = T)
outliers_v44<-dheeraj$v44[dheeraj$v44>3]
na.omit(outliers_v44)
boxplot(outliers_v44,horizontal  =T)


#outliers in v45 
boxplot(dheeraj$v45,horizontal = T)
outliers_v45<-dheeraj$v45[dheeraj$v45>7]
na.omit(outliers_v45)
boxplot(outliers_v45,horizontal  =T)


#outliers in v46

boxplot(dheeraj$v46,horizontal = T)
outliers_v46<-dheeraj$v46[dheeraj$v46>8]
na.omit(outliers_v46)
boxplot(outliers_v43,horizontal  =T)




#2)_d)a)

#correaltaion Acc. to given question
cor(dheeraj$v40,dheeraj$gdp,use = "complete.obs")
cor(dheeraj$v40,dheeraj$tap,use = "complete.obs")
cor(dheeraj$v40,dheeraj$beds,use = "complete.obs")

cor(dheeraj$v42,dheeraj$gdp,use = "complete.obs")
cor(dheeraj$v42,dheeraj$tap,use = "complete.obs")
cor(dheeraj$v42,dheeraj$beds,use = "complete.obs")

cor(dheeraj$v43,dheeraj$gdp,use = "complete.obs")
cor(dheeraj$v43,dheeraj$tap,use = "complete.obs")
cor(dheeraj$v43,dheeraj$beds,use = "complete.obs")

cor(dheeraj$v44,dheeraj$gdp,use = "complete.obs")
cor(dheeraj$v44,dheeraj$tap,use = "complete.obs")
cor(dheeraj$v44,dheeraj$beds,use = "complete.obs")

cor(dheeraj$v45,dheeraj$gdp,use = "complete.obs")
cor(dheeraj$v45,dheeraj$tap,use = "complete.obs")
cor(dheeraj$v45,dheeraj$beds,use = "complete.obs")

cor(dheeraj$v46,dheeraj$gdp,use = "complete.obs")
cor(dheeraj$v46,dheeraj$tap,use = "complete.obs")
cor(dheeraj$v46,dheeraj$beds,use = "complete.obs")



#2)_d)b)
#correlation of v40 with cash
a<-dheeraj$index [dheeraj$cropcategory=='Cash'] # saving cash index 
b<-dheeraj$v40 [dheeraj$cropcategory=='Cash'] # v40 value of cash
cor(a,b,use = "complete.obs")

a<-dheeraj$index [dheeraj$cropcategory=='Cereal'] # saving cash index 
b<-dheeraj$v42 [dheeraj$cropcategory=='Cereal'] # v40 value of cash
cor(a,b,use = "complete.obs")

a<-dheeraj$index [dheeraj$cropcategory=='Horticulture'] # saving cash index 
b<-dheeraj$v43 [dheeraj$cropcategory=='Horticulture'] # v40 value of cash
cor(a,b,use = "complete.obs")

a<-dheeraj$index [dheeraj$cropcategory=='Pulse'] # saving cash index 
b<-dheeraj$v44 [dheeraj$cropcategory=='Pulse'] # v40 value of cash
cor(a,b,use = "complete.obs")

a<-dheeraj$index [dheeraj$cropcategory=='Oilseed'] # saving cash index 
b<-dheeraj$v45 [dheeraj$cropcategory=='Oilseed'] # v40 value of cash
cor(a,b,use = "complete.obs")

a<-dheeraj$index [dheeraj$cropcategory=='Coarse Cereal'] # saving cash index 
b<-dheeraj$v46 [dheeraj$cropcategory=='Coarse Cereal'] # v40 value of cash
cor(a,b,use = "complete.obs")


#part c

  


# Q_3

lin_mod = lm(formula = v40 ~ gdp + beds + tap, data = dheeraj)
summary(lin_mod)


#Part b
#making subest from data


#------- for cereal
cereal<-c('Cereal')
cereal_df<-dheeraj[dheeraj$cropcategory %in%cereal,]
print(cereal_df)
cereal_df[is.na(cereal_df) | cereal_df == "Inf"] <- NA
lin_mod_1 = lm(formula = v40 ~ gdp + beds + tap + index, data = cereal_df)
summary(lin_mod_1)





#---------for coarse 
coarse<-c('Coarse Cereal')
coarse_df<-dheeraj[dheeraj$cropcategory %in%coarse,]
coarse_df[is.na(coarse_df) | coarse_df == "Inf"] <- NA
lin_mod_2 = lm(formula = v40 ~ gdp + beds + tap + index, data = coarse_df)
summary(lin_mod_2)

#----------for cash

cash<-('Cash')
cash_df<-dheeraj[dheeraj$cropcategory %in%cash,]
lin_mod_3 = lm(formula = v40 ~ gdp + beds + tap + index, data = cash_df)
summary(lin_mod_3)

#-------for oilseeds
oilseed<-('Oilseed')
oilseed_df<-dheeraj[dheeraj$cropcategory %in%oilseed,]
lin_mod_4 = lm(formula = v40 ~ gdp + beds + tap + index, data = oilseed_df)
summary(lin_mod_4)


#-----for horticulture
horticulture<-('Horticulture')
horticulture_df<-dheeraj[dheeraj$cropcategory %in%horticulture,]
lin_mod_5 = lm(formula = v40 ~ gdp + beds + tap + index, data = horticulture_df)
summary(lin_mod_5)

#-----for Pulse
pulse<-('Pulse')
pulse_df<-dheeraj[dheeraj$cropcategory %in%pulse,]
lin_mod_6 = lm(formula = v40 ~ gdp + beds + tap + index, data = pulse_df)
summary(lin_mod_6)

#part c











