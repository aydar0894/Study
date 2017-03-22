using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Artificial_Neural_Netwok_hierarchy.ANN
{
   abstract class Artificial_Neural_Network : Computer_Programm, Learnable
    {
        Object[] input;
        Neuron[] neuralNet;
        Object[][] trainingSet;

         void Learnable.teach(Type t)
        {

        }

         float Learnable.setParams(params object[] p)
        {
            return 0;
        }


    }
}
