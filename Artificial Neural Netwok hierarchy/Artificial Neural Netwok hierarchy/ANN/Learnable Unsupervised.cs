using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Artificial_Neural_Netwok_hierarchy.ANN
{
    public interface Learnable_Unsupervised : Learnable
    {
        Object[] approxFunction(Object[] input);

        void changeWeights(Object[] network);
       
    }
}
