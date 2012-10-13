#!/usr/bin/perl

use HTML::Parser ();
use Data::Dumper;

use strict;
use warnings;

sub start_handler
{
    return if shift ne "title";
    my $self = shift;
    $self->handler(text => sub { print shift }, "dtext");
    $self->handler(end  => sub { shift->eof if shift eq "title"; },
        "tagname,self");
}

my $p = HTML::Parser->new(api_version => 3);

$p->handler( start => &start_handler, "a,self");
$p->parse_file("data/agendas") || die $!;

