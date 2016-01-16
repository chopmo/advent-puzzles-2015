

i = 0; while true; hex = Digest::MD5.new.update("bgvyzdsv#{i}").hexdigest; puts i and break if  hex[0..5] == '000000'; i += 1; end


