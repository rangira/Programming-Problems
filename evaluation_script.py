import os
lst = ['amhagen','joeydm','trjroger']
os.system('ls')
for ele in lst:
        os.system('mkdir '+ele)
        os.system('cd '+ele)
        os.system('git clone https://github.iu.edu/'+ele+'/C291-Spring1-2017')
        os.system('cd ..')
