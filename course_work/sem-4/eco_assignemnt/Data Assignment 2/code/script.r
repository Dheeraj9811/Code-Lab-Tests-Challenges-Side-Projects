library(tidyr)
library(ggplot2)

# data import
data = read.csv("normfile.csv")

# data in kharif season
# foodgrain crop-type
data_kf = subset(data, data$season=='Kharif'&data$rbicat=='Foodgrain')
# commercial crop-type
data_kc = subset(data, data$season=='Kharif'&data$rbicat=='Commercial')

# data in rabi season
# foodgrain crop-type
data_rf = subset(data, data$season=='Rabi'&data$rbicat=='Foodgrain')
# commercial crop-type
data_rc = subset(data, data$season=='Rabi'&data$rbicat=='Commercial')

# post-partum care variable
pp_kf = data_kf$v18 + data_kf$v19
pp_kc = data_kc$v18 + data_kc$v19
pp_rf = data_rf$v18 + data_rf$v19
pp_rc = data_rc$v18 + data_rc$v19

# MLRMs 
model_kf = lm(v41~gdp+beds+yieldtonneshectare+v19+v7+v3+v13+v27, data_kf)
model_kc = lm(v41~gdp+beds+yieldtonneshectare+v19+v7+v3+v13+v27, data_kc)
model_rf = lm(v41~gdp+beds+yieldtonneshectare+v19+v7+v3+v13+v27, data_rf)
model_rc = lm(v41~gdp+beds+yieldtonneshectare+v19+v7+v3+v13+v27, data_rc)


#Predicted Y for Kharif Commercial
predi_y_kc = c()
sum_m_kc = summary(model_kc)$coef

for (i in 1:nrow(data_kc)){
  y = sum_m_kc[1,1] + sum_m_kc[2,1]*data_kc[i,75] + sum_m_kc[3,1]*data_kc[i,73] + sum_m_kc[4,1]*data_kc[i,14] + sum_m_kc[5,1]*data_kc[i,35]
  + sum_m_kc[6,1]*data_kc[i,23 ] + sum_m_kc[7,1]*data_kc[i,19] + sum_m_kc[8,1]*data_kc[i,29] + sum_m_kc[9,1]*data_kc[i,43]
  predi_y_kc = c(predi_y_kc, y)
}

#Error term for Kharif Commercial
er_y_kc = c()
for(i in 1:length(predi_y_kc)){
  y_dif = data_kc[i,57] - predi_y_kc[i]
  er_y_kc = c(er_y_kc, y_dif)
}

#Predicted Y for Rabi Commercial
predi_y_rc = c()
sum_m_rc = summary(model_rc)$coef

for (i in 1:nrow(data_rc)){
  y = sum_m_rc[1,1] + sum_m_rc[2,1]*data_rc[i,75] + sum_m_rc[3,1]*data_rc[i,73] + sum_m_rc[4,1]*data_rc[i,14] + sum_m_rc[5,1]*data_rc[i,35]
  + sum_m_rc[6,1]*data_rc[i,23 ] + sum_m_rc[7,1]*data_rc[i,19] + sum_m_rc[8,1]*data_rc[i,29] + sum_m_rc[9,1]*data_rc[i,43]
  predi_y_rc = c(predi_y_rc, y)
}

#Error term for Rabi Commercial
er_y_rc = c()
for(i in 1:length(predi_y_rc)){
  y_dif = data_rc[i,57] - predi_y_rc[i]
  er_y_rc = c(er_y_rc, y_dif)
}

#q1 b part
plot(x = data_kc$index, y = data_kc$v41, main = "Asphysxia vs Yield Index for Kharif", xlab = "Yield Index during Kharif", ylab = "Deaths due to Asphyxia during Kharif")
plot(x = data_rc$index, y = data_rc$v41, main = "Asphysxia vs Yield Index for Rabi", xlab = "Yield Index during Rabi", ylab = "Deaths due to Asphyxia during Rabi")

plot(x = data_kc$index, y = er_y_kc, main = "Error y vs Yield Index for Kharif", xlab = "Yield Index during Kharif", ylab = "True - Predicted Value")
plot(x = data_rc$index, y = er_y_rc, main = "Error y vs Yield Index for Rabi", xlab = "Yield Index during Rabi", ylab = "True - Predicted Value")


plot(x = data_kc$v41, y = predi_y_kc, main = "Predicted vs True for Kharif", xlim = c(1,40), xlab = "Given Deaths due to Asphyxia during Kharif", ylab = "Predicted Deaths due to Asphyxia during Kharif")
plot(x = data_rc$v41, y = predi_y_rc, main = "Predicted vs True for Rabi", xlim = c(1,60), xlab = "Given Deaths due to Asphyxia during Kharif", ylab = "Predicted Deaths due to Asphyxia during Kharif")
#q1 b part ends


#q1 c part starts
hist(er_y_kc, main = "Histogram of U-hat during Kharif", xlab = "U-hat")
hist(er_y_rc, main = "Histogram of U-hat during Rabi", xlab = "U-hat")
sum(er_y_kc)
#q1 c part ends

#q1 part d starts
gdp_e_kc = c()
gdp_e_rc = c()
beds_e_kc = c()
beds_e_rc = c()
yield_e_kc = c()
yield_e_rc = c()
v19_e_kc = c()
v19_e_rc = c()
v7_e_kc = c()
v7_e_rc = c()
v3_e_kc = c()
v3_e_rc = c()
v13_e_kc = c()
v13_e_rc = c()
v27_e_kc = c()
v27_e_rc = c()

for(i in 1:nrow(data_kc)){
  gdp_e_kc = c(gdp_e_kc, er_y_kc[i]*data_kc[i,75])
  beds_e_kc = c(beds_e_kc, er_y_kc[i]*data_kc[i,73])
  yield_e_kc = c(yield_e_kc, er_y_kc[i]*data_kc[i,14])
  v19_e_kc = c(v19_e_kc, er_y_kc[i]*data_kc[i,35])
  v7_e_kc = c(v7_e_kc, er_y_kc[i]*data_kc[i,23])
  v3_e_kc = c(v3_e_kc, er_y_kc[i]*data_kc[i,19])
  v13_e_kc = c(v13_e_kc, er_y_kc[i]*data_kc[i,29])
  v27_e_kc = c(v27_e_kc, er_y_kc[i]*data_kc[i,43])
}

for(i in 1:nrow(data_rc)){
  gdp_e_rc = c(gdp_e_rc, er_y_rc[i]*data_rc[i,75])
  beds_e_rc = c(beds_e_rc, er_y_rc[i]*data_rc[i,73])
  yield_e_rc = c(yield_e_rc, er_y_rc[i]*data_rc[i,14])
  v19_e_rc = c(v19_e_rc, er_y_rc[i]*data_rc[i,35])
  v7_e_rc = c(v7_e_rc, er_y_rc[i]*data_rc[i,23])
  v3_e_rc = c(v3_e_rc, er_y_rc[i]*data_rc[i,19])
  v13_e_rc = c(v13_e_rc, er_y_rc[i]*data_rc[i,29])
  v27_e_rc = c(v27_e_rc, er_y_rc[i]*data_rc[i,43])
}

hist(gdp_e_kc, main = "GDP*u during Kharif", xlab = "GDP*u")
hist(gdp_e_rc, main = "GDP*u during Rabi", xlab = "GDP*u")
hist(beds_e_kc, main = "Beds*u during Kharif", xlab = "Beds*u")
hist(beds_e_rc, main = "Beds*u during Rabi", xlab = "Beds*u")
hist(yield_e_kc, main = "Yield*u during Kharif", xlab = "Yield*u")
hist(yield_e_rc, main = "Yield*u during Rabi", xlab = "Yield*u")
hist(v19_e_kc, main = "v19*u during Kharif", xlab = "v19*u")
hist(v19_e_rc, main = "v19*u during Rabi", xlab = "v19*u")
hist(v7_e_kc, main = "v7*u during Kharif", xlab = "v7*u")
hist(v7_e_rc, main = "v7*u during Rabi", xlab = "v7*u")
hist(v3_e_kc, main = "v3*u during Kharif", xlab = "v3*u")
hist(v3_e_rc, main = "v3*u during Rabi", xlab = "v3*u")
hist(v13_e_kc, main = "v13*u during Kharif", xlab = "v13*u")
hist(v13_e_rc, main = "v13*u during Rabi", xlab = "v13*u")
hist(v27_e_kc, main = "v27*u during Kharif", xlab = "v27*u")
hist(v27_e_rc, main = "v27*u during Rabi", xlab = "v27*u")

sum(gdp_e_kc)
sum(gdp_e_rc)
sum(beds_e_kc)
sum(beds_e_rc)
sum(yield_e_kc)
sum(yield_e_rc)
sum(v19_e_kc)
sum(v19_e_rc)
sum(v7_e_kc)
sum(v7_e_rc)
sum(v3_e_kc)
sum(v3_e_rc)
sum(v13_e_kc)
sum(v13_e_rc)
sum(v27_e_kc)
sum(v27_e_rc)
#q1 part d ends



#Q2 code starts

library(tidyr)
data = read.csv("normfile.csv")
Asphyxia_data = subset(data,v41 <= 46.14)
model = lm(formula = v41 ~ index, data = Asphyxia_data)
summary(model)
all_coefficient = summary(model)$coefficients  
true_B0 = all_coefficient[1,1]
true_B1 = all_coefficient[2,1]

B0_sum = 0
B1_sum = 0
count = 100
v1<-c()
v2<-c()
for (x in 1:count) {
  sub_sample = Asphyxia_data[sample(1:nrow(Asphyxia_data), 80*(nrow(Asphyxia_data)/100)), ]  
  temp_model = lm(v41 ~ index, sub_sample)
  all = summary(temp_model)$coefficients
  temp_B0 = all[1,1]
  temp_B1 = all[2,1]
  v1<-c(v1,temp_B0)
  v2<-c(v2,temp_B1)
  B0_sum = B0_sum + temp_B0
  B1_sum = B1_sum + temp_B1
}

hist(v1,xlab='Intercept(n=100)')
abline(v=mean(v1),col="blue")
abline(v=10.2131,col="red")

hist(v2,xlab='Coeff of Yield Index(n=100)')
abline(v=mean(v2),col="blue")
abline(v=0.11642,col="red")

B0_sum/count
B1_sum/count
true_B0 - B0_sum/count
true_B1 - B1_sum/count

B0_sum = 0
B1_sum = 0
count = 500
v1<-c()
v2<-c()
for (x in 1:count) {
  sub_sample = Asphyxia_data[sample(1:nrow(Asphyxia_data), 80*(nrow(Asphyxia_data)/100)), ]  
  temp_model = lm(v41 ~ index, sub_sample)
  all = summary(temp_model)$coefficients
  temp_B0 = all[1,1]
  temp_B1 = all[2,1]
  v1<-c(v1,temp_B0)
  v2<-c(v2,temp_B1)
  B0_sum = B0_sum + temp_B0
  B1_sum = B1_sum + temp_B1
}
hist(v1,xlab='Intercept(n=500)')
abline(v=mean(v1),col="blue")
abline(v=10.2131,col="red")

hist(v2,xlab='Coeff of Yield Index(n=500)')
abline(v=mean(v2),col="blue")
abline(v=0.11642,col="red")

B0_sum/count
B1_sum/count
true_B0 - B0_sum/count
true_B1 - B1_sum/count

B0_sum = 0
B1_sum = 0
count = 10000
v1<-c()
v2<-c()
for (x in 1:count) {
  sub_sample = Asphyxia_data[sample(1:nrow(Asphyxia_data), 80*(nrow(Asphyxia_data)/100)), ]  
  temp_model = lm(v41 ~ index, sub_sample)
  all = summary(temp_model)$coefficients
  temp_B0 = all[1,1]
  temp_B1 = all[2,1]
  v1<-c(v1,temp_B0)
  v2<-c(v2,temp_B1)
  B0_sum = B0_sum + temp_B0
  B1_sum = B1_sum + temp_B1
}

hist(v1,xlab='Intercept(n=10000)')
abline(v=mean(v1),col="blue")
abline(v=10.2131,col="red")

hist(v2,xlab='Coeff of Yield Index(n=10000)')
abline(v=mean(v2),col="blue")
abline(v=0.11642,col="red")

B0_sum/count
B1_sum/count
true_B0 - B0_sum/count
true_B1 - B1_sum/count

#Q2 code ends


# Dummy Variables (kc)
D_n_kc = rep(0, nrow(data_kc))
D_s_kc = rep(0, nrow(data_kc)) 
D_e_kc = rep(0, nrow(data_kc))
D_w_kc = rep(0, nrow(data_kc))
D_c_kc = rep(0, nrow(data_kc))
D_ne_kc = rep(0, nrow(data_kc))

for(i in 1:nrow(data_kc)) {
  if(data_kc$state[i] %in% c('Himachal Pradesh', 'Punjab', 'Uttarakhand', 'Uttar Pradesh', 'Haryana'))
    D_n_kc[i] = 1
  else if(data_kc$state[i] %in% c('Bihar', 'Orissa', 'Jharkhand', 'West Bengal'))
    D_e_kc[i] = 1
  else if(data_kc$state[i] %in% c('Rajasthan', 'Gujarat', 'Goa', 'Maharashtra'))
    D_w_kc[i] = 1
  else if(data_kc$state[i] %in% c('Andhra Pradesh', 'Telangana', 'Karnataka', 'Kerala', 'Tamil Nadu'))
    D_s_kc[i] = 1
  else if(data_kc$state[i] %in% c('Madhya Pradesh', 'Chhattisgarh'))
    D_c_kc[i] = 1
  else if(data_kc$state[i] %in% c('Assam', 'Sikkim', 'Nagaland', 'Meghalaya', 'Manipur', 'Mizoram', 'Tripura', 'Arunachal Pradesh'))
    D_ne_kc[i] = 1
}
data_kc['D_n_kc'] = D_n_kc
data_kc['D_s_kc'] = D_s_kc
data_kc['D_e_kc'] = D_e_kc
data_kc['D_w_kc'] = D_w_kc
data_kc['D_c_kc'] = D_c_kc
data_kc['D_ne_kc'] = D_ne_kc

# Dummy Variables (rc)
data_rc$D_n_rc = rep(0, nrow(data_rc))
data_rc$D_s_rc = rep(0, nrow(data_rc)) 
data_rc$D_e_rc = rep(0, nrow(data_rc))
data_rc$D_w_rc = rep(0, nrow(data_rc))
data_rc$D_c_rc = rep(0, nrow(data_rc))
data_rc$D_ne_rc = rep(0, nrow(data_rc))

for(i in 1:nrow(data_rc)) {
  if(data_rc$state[i] %in% c('Himachal Pradesh', 'Punjab', 'Uttarakhand', 'Uttar Pradesh', 'Haryana'))
    data_rc$D_n_rc[i] = 1
  else if(data_rc$state[i] %in% c('Bihar', 'Orissa', 'Jharkhand', 'West Bengal'))
    data_rc$D_e_rc[i] = 1
  else if(data_rc$state[i] %in% c('Rajasthan', 'Gujarat', 'Goa', 'Maharashtra'))
    data_rc$D_w_rc[i] = 1
  else if(data_rc$state[i] %in% c('Andhra Pradesh', 'Telangana', 'Karnataka', 'Kerala', 'Tamil Nadu'))
    data_rc$D_s_rc[i] = 1
  else if(data_rc$state[i] %in% c('Madhya Pradesh', 'Chhattisgarh'))
    data_rc$D_c_rc[i] = 1
  else if(data_rc$state[i] %in% c('Assam', 'Sikkim', 'Nagaland', 'Meghalaya', 'Manipur', 'Mizoram', 'Tripura', 'Arunachal Pradesh'))
    data_rc$D_ne_rc[i] = 1
}

# Model with Dummy Variable (Kharif-Commercial & Rabi-Commercial)
lm_n_kc = lm(v41~gdp+beds+yieldtonneshectare+v19+v7+v3+v13+v27+D_n_kc, data_kc)
lm_n_rc = lm(v41~gdp+beds+yieldtonneshectare+v19+v7+v3+v13+v27+D_n_rc, data_rc)

lm_s_kc = lm(v41~gdp+beds+yieldtonneshectare+v19+v7+v3+v13+v27+D_s_kc, data_kc)
lm_s_rc = lm(v41~gdp+beds+yieldtonneshectare+v19+v7+v3+v13+v27+D_s_rc, data_rc)

lm_e_kc = lm(v41~gdp+beds+yieldtonneshectare+v19+v7+v3+v13+v27+D_e_kc, data_kc)
lm_e_rc = lm(v41~gdp+beds+yieldtonneshectare+v19+v7+v3+v13+v27+D_e_rc, data_rc)

lm_w_kc = lm(v41~gdp+beds+yieldtonneshectare+v19+v7+v3+v13+v27+D_w_kc, data_kc)
lm_w_rc = lm(v41~gdp+beds+yieldtonneshectare+v19+v7+v3+v13+v27+D_w_rc, data_rc)

lm_c_kc = lm(v41~gdp+beds+yieldtonneshectare+v19+v7+v3+v13+v27+D_c_kc, data_kc)
lm_c_rc = lm(v41~gdp+beds+yieldtonneshectare+v19+v7+v3+v13+v27+D_c_rc, data_rc)

aov(v41~gdp+beds+yieldtonneshectare+v19+v7+v3+v13+v27+D_c_rc, data_rc)
