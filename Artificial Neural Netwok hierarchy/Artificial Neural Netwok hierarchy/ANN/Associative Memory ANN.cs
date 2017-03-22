using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Artificial_Neural_Netwok_hierarchy.ANN
{
    sealed class Associative_Memory_ANN : Artificial_Neural_Network, Learnable_Unsupervised
    {    
        Object[] Learnable_Unsupervised.approxFunction(Object[] input)
        {
            return null;
        }

        void Learnable_Unsupervised.changeWeights(object[] network)
        {
            throw new NotImplementedException();
        }
    }
}
