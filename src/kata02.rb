$i = 0
def myfunc(x)
  puts $i
end
a = []
1000.times { a << rand(0..1000)}
a.sort!
b = a.slice(0, a.length/2)
c = a.slice(a.length/2, a.length)

myfunc("sri")