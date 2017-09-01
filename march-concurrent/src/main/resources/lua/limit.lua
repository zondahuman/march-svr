--
-- Created by IntelliJ IDEA.
-- User: lisubin
-- Date: 2017/9/1
-- Time: 11:21
-- To change this template use File | Settings | File Templates.
--

local redis = require 'redis'
local client = redis.connect('172.16.2.146', 6379)
local response = client:ping()            --true
print("ping--KEYS[1] :", KEYS[1])
print("ping--response :", response)


local times = client:incr(KEYS[1]) --设置key(KEY[1])并加1

if times == 1 then
    client:expire(KEYS[1], ARGV[1]) --设置超时时间
end


if times > tonumber(ARGV[2]) then --限流大小
return 0
end

return 1




--local times = redis.call('incr', KEYS[1]) --设置key(KEY[1])并加1
--
--if times == 1 then
--redis.call('expire', KEYS[1], ARGV[1]) --设置超时时间
--end
--
--
--if times > tonumber(ARGV[2]) then --限流大小
--return 0
--end
--
--return 1