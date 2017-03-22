using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Artificial_Neural_Netwok_hierarchy.ANN
{
    sealed class Classification_ANN : Artificial_Neural_Network, Learnable_Supervised
    {
        
        object[][] Learnable_Supervised.buildTrainingSet()
        {
            Object[][] trainingSet = { };
            return trainingSet;
        }


        float Learnable_Supervised.testTrainingSet(object[][] trainingSet)
        {
            throw new NotImplementedException();
        }
     
       


    }
}
