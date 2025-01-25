function []= my_source(a,b,info)
% here a is amplitude of sound file and b is frequency of sound file 

%ATQ display max frequency
display(max(b)/2)

%%

multi1 = 10;
array_d = a(1:multi1:length(a));%reducing sample 
array_u = zeros(1,length(a)); % initationating array of same size as audio
array_u(1:multi1:length(array_u)) = array_d;% puting value of original audio and leaving others as zero

T_sample = info.TotalSamples; 
% showing oversampling
    %making spectrum to change into fourier
    fre = linspace(0,b,T_sample);

    Y = abs(fft(array_u));
    figure(4);
    subplot(211);
    plot(fre(1:T_sample/2),Y(1:T_sample/2));
    title('oversampling part(ii)');
    xlabel('time',BackgroundColor= 'red');
    ylabel('Amplitude',BackgroundColor= 'red');


    %%%%% showing under sampling
multi1 = 1.6;
array_d = a(1:multi1:length(a));
array_u = zeros(1,multi1*length(array_d));
array_u(1:multi1:length(array_u)) = array_d;

T_sample = info.TotalSamples; 
    %making spectrum to change into fourier
    fre = linspace(0,b,T_sample);
    Y = abs(fft(array_u,T_sample));
    subplot(212);
    plot(fre(1:T_sample/8),Y(1:T_sample/8));
    title('under sampling part(i)');
    xlabel('Time',BackgroundColor= 'red');
    
    ylabel('Amplitude',BackgroundColor= 'red');

%When we take the frequency less then the nyquist rate we get aliasing
%and signal cannot be filterd out but when we take frequency greater than
% nyquist rate we were able to filter out our signal












end