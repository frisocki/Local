<?php
for ($i = 1; $i <= file_get_contents($argv[1]); $i++) {
  if     ($i % (3*5) == 0) { print "Hop\n"; }
  elseif ($i % 3     == 0) { print "Hoppity\n"; }
  elseif ($i % 5     == 0) { print "Hophop\n"; }
}
