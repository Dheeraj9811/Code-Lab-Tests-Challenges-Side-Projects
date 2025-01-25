function [amp_max]= my_quantize(a,b,info)
% all the extra refence material other then books : 
% 1) https://in.mathworks.com/help/comm/ref/quantiz.html
% 2) https://in.mathworks.com/matlabcentral/answers/631559-how-to-quantize-the-audio-file
% 3) https://www.youtube.com/watch?v=e1p0xsj9Xa8
% 4) https://www.youtube.com/watch?v=Q59-LrIM_18&t=95s
amax = max(a); 
amp_max = a/amax;
%{ I chose L = 16 because it is the midpoint of the MSE versus quantisation level graph,
% indicating that if L is less, our Noise power would be higher, and if L is larger,
% our input signal will be comparable. As a result, we must pick a decent value for L 
% so that the signal is quantized appropriately.}
L = 16;
lvl_s = (max(a)-min(a))/L; lvl_s= lvl_s(1);

%quantize lvl 
q_lvl = lvl_s.*(0:15);
q_lvl = q_lvl-15/2*lvl_s;



for i=1:16
    amp_max(find((q_lvl(i)-lvl_s/2<=amp_max)&(amp_max<=q_lvl(i)+lvl_s/2)))=q_lvl(i).*ones(1,length(find((q_lvl(i)-lvl_s/2<=amp_max)&(amp_max<=q_lvl(i)+lvl_s/2))));
    amp_max (find(amp_max==q_lvl(i)))=(i-1).*ones(1,length(find(amp_max==q_lvl(i))));
end

figure(5)
plot((0:length(a)-1)/b,amp_max);


%% Part 2 MSE
% 
a = a(:,1); % making single channel
max_aplitude = max(a);
    n=1:1:8;
    % L = 2^n, we know MSE = Nq = mp^2/(3*L^2);
    i = 1;
    while i <= 8
        x(i)=max_aplitude^2/(3*2^(2*i)); % MSE VALUES USING QUANTIZATION ERROR FORMULA
        i = i + 1;
    end
    figure(6)
    plot(n,x,'-x');
    ylabel('MSE');
    xlabel('n(L=2^n)');
    title('MSE V/S different value of n');



end