#!/usr/bin/env python
import csv


def main(filename):
    from collections import defaultdict

    with open(filename,'r') as handle:
        reader = csv.DictReader(handle,['name','events','cities'])
        data = defaultdict(list)
    
        for line in reader:
            data[line['name']].append(int(line['events']))
    
        for person,numevents in data.items():
            print '{} has attended {} events with an average of {}'.format(person,sum(numevents),sum(numevents)/float(len(numevents)))


main('../../csv_report/data/test.csv')   
