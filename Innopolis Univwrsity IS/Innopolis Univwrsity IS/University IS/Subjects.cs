using System.Diagnostics.Contracts;

namespace Innopolis_Univwrsity_IS.University_IS
{
    class Subjects
    {
        public int count;
        public Subject[] subjects = new Subject[15];
        public Subjects()
        {
            count = 0;
        }
        public Subject add(string name)
        {
            subjects[count] = new Subject(name,count);
            count++;
            Contract.Ensures(count > 0, "Count is less than 0!");
            return subjects[count - 1];           
        }
        public Subject add(Subject subj)
        {
            this.subjects[count] = subj;
            count++;
            Contract.Ensures(count > 0, "Count is less than 0!");
            return this.subjects[count - 1];
        }

        public int getCount()
        {
            return count;
        }

        public Subject search(string name)
        {
            for (int i = 0; i < count; i++)
            {
                if (subjects[i].Name == name) return subjects[i];
            }
            return null;
        }




    }

}
