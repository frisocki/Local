#!/usr/bin/env python
from decimal import *
import math
  
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

  print choose(4,3)

  combos = Decimal(choose(people, winners))

  for i in range(group, 0, -1):
    print i
    winning_people = people - i
    winning_group  = winners - i
    if winning_group == 0:
      winning_picks = people
    else:
      winning_picks = Decimal(choose(winning_people, winning_group))
    print "winning picks:", winning_picks
    
