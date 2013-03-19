///<summary>
///This is a little project to read a csv file and write a correct output as follows:
///'name' has attended 'number of events' with an average of 'average of events'
///</summary>


using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace csvReader
{
    class Program
    {
        public static void ReadCSV(string filename)
        {
            var readlines = File.ReadAllLines(filename);
            var query = from lines in readlines
                        let data = lines.Split(',')
                        select new
                        {
                            Name = data[0],
                            Events = data[1],
                            City = data[2]
                        };

            var values = query.GroupBy(x => new {x.Name}).Select(group => new { Person = group.Key, Events = group.Sum(g =>Convert.ToDouble(g.Events)) ,Count = group.Count() });
            
            foreach (var value in values)
            {
                double average = value.Events /value.Count;
                Console.WriteLine("{0} has attended {1} events, and with an average of {2} ",value.Person.Name,value.Events,average);

            }
                
        }




        static void Main(string[] args)
        {
            string filename = (@"E:\Csharp\csvReader\test.csv");
            ReadCSV(filename);

            Console.Read();

        }
    }
}
