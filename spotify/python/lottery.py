#!/usr/bin/env python
from decimal import *
  
def choose(n, r):
  i = Decimal(1);

  for k in range(r):
    i = i * (n-k) / (k+1)

  return i
  
if __name__ == '__main__':
  numbers = raw_input().split(" ")

  people  = int(numbers[0])
  winners = int(numbers[1])
  tickets = int(numbers[2])
  group   = int(numbers[3])

  if group > winners:
    print 0.0
  else:
    people  = people
    winners = winners
    nwinners = winners

    non_winners = people - winners
    print "non-winners", non_winners
  
    if non_winners < winners:
      nwinners = non_winners
  #  nwinners    = non_winners
  #  non_winners = winners
    else:
      non_winners += winners - group

    print "people", people
    print "winners", winners
    print "non-winners", non_winners

    print non_winners, "choose" , nwinners
    print people, "choose", winners
    # Call the function with users variables
    #print choose(5, 5)
    #print choose(4, 3)
  
    r = 1 - Decimal(choose(non_winners, nwinners)) / Decimal(choose(people, winners))
    print r
    #print("%.10f" % r)
