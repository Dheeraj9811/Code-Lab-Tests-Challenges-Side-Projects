
function [amplitude , freq,info] = my_input(enter)
load handel.mat

% Reading audio file and storing dtata
% in the info we are saving duration of file (that is 5 sec A.T.Q), no of channels in a file etc, which we may use   
[amplitude,freq] = audioread(enter);
info = audioinfo(enter);
amplitude = amplitude(:,1);% changing to single channel

% A.T.Q  characteristics in time domain 
% info.Duration 
td = 0:seconds(1/freq): seconds(info.Duration);% this is array of time 
td = td(1:end-1);

    %now making plot to show time domain 
    figure(1);
    plot(td,amplitude);
    title('Time domain');
    xlim(seconds([0 5.5])); % setting x limit
    xlabel('Time in sec',BackgroundColor= 'red');
    ylabel('Amplitude',BackgroundColor= 'red');
    
    
% ATQ now we have to find characterstic in freq domian so first we do
% fourier transform here then use plot fn to plot in freq domain in
% similaer way as above

% we will use in built tool for fourier transform

T_sample = info.TotalSamples; 
    %making spectrum to change into fourier
    fre = linspace(0,freq,T_sample);% making vector
    Y = fftshift(fft(amplitude,T_sample)); % USING FFTSHIFT TO THE FOURIER TRANSFORM SUCH THAT IT BECOMES BASEBAND
    figure(2);
    plot(fre(1:T_sample),abs(Y(1:T_sample)));
    title('freq domain');
    xlabel('freqency',BackgroundColor= 'red');
    ylabel('Amplitude',BackgroundColor= 'red');

figure(3)
    plot(fre(1:T_sample),unwrap(angle(Y(1:T_sample))));
    title('freq domain');
    xlabel('freqency',BackgroundColor= 'red');
    ylabel('phase',BackgroundColor= 'red');
  
    %% dlt this just doing some checking to detect error in code
% %     amplitude = ifft(Y);
%     figure(10);
%     title('Time domain');
%     plot(td,amplitude);
%     xlim(seconds([0 5.5])); % setting x limit
%     xlabel('Time in sec',BackgroundColor= 'red');
%     ylabel('Amplitude',BackgroundColor= 'red');

% applying filter now  by / 4 
% figure(3);
% plot(fre(1:T_sample),Y(1:T_sample));

end
