%% PCS Assignment

t = (-0.1:0.000001:+0.1);
fc = 1000; %frequency of carrier signal
fm = 10; %frequency of message signal

A =1;  %amplitude of the carrier signal

m = cos(2*pi*fc*t);

Vdsb = A.*m.*cos(2*pi*fm*t);
figure(1);
plot(t,Vdsb);


%-----part 2 case 1 

Ac = 2
figure(2);
Vdsb_am = Ac.*cos(2*pi*fc*t) + Vdsb;
plot(t,Vdsb_am);
title("ac = 2")




%-----case 2 
Ac = 1
figure(3);
Vdsb_am = Ac.*cos(2*pi*fc*t) + Vdsb;
plot(t,Vdsb_am);
title("ac = 1")


%-----case 3
Ac = 0.5
figure(4);
Vdsb_am = Ac.*cos(2*pi*fc*t) + Vdsb;
plot(t,Vdsb_am);
title("ac = 0.5")

% for the value of ac =1 its follows the message signal