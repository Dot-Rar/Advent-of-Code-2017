use strict;
use warnings;
use Set::Object qw(set);

my $above = set();
my $all = set();

open(my $fh, '<:encoding(UTF-8)', 'day7.txt')
     or die;

while(my $row = <$fh>) {
    chomp $row;
    if($row =~ /(\w+)\ \((\d+)\)(?: -> (.*))?/) {
        $all->insert($1);
        if(defined($3)) {
            my @discs = split(/, /, $3);
            for my $disc(@discs) {
                $above->insert($disc);
            }
        }
    }
}

for my $disc(@$all) {
    if(!$above->includes($disc)) {
        print $disc;
        last;
    }
}
