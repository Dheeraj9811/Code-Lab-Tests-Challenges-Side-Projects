% my input is the fn in which you have to add location of your sound file.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% part 1 and 2 
[amp , freq,info] = my_input("D:\Desktop\pcs_assignment4\assign_audio.wav");

% part 3
my_source(amp,freq,info);

%part 4 
[amp_max]=my_quantize(amp,freq,info);

%part5
my_encoder(amp,freq,amp_max);


