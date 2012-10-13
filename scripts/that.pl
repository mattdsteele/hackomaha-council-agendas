use JSON;
use Data::Dumper;

my $thething = {
    query => {

    }
};

my $json = encode_json($thething);
my $result = `curl -X GET 'simomaha.com/citycouncil/agendas/_search' -d $json`;
print &Dumper(decode_json($result));
