function []= my_encoder(a,b,amp_max)
encoderbit = strings(length(amp_max),1)
for i = 1:1:length(amp_max)
    encoderbit(i) = dec2bin(amp_max(i),5);%changing to decimal to binary 
end
encoderbit

end