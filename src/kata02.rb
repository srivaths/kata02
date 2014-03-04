$search_for = 0
def myfunc(start_index, ary)
  length = ary.length
  first = ary.slice(0, length/2)
  last = ary.slice(length/2, length)
  // End processing
  if length == 2
    if $search_for == ary[0]
      return start_index
    else
      return start_index + 1
    end
  if $search_for < last[0]
    myfunc(start_index, first)
  else
    myfunc(start_index + length/2, last)
end
a = []
1000.times { a << rand(0..1000)}
a.sort!
b = a.slice(0, a.length/2)
c = a.slice(a.length/2, a.length)

myfunc("sri")