using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Artificial_Neural_Netwok_hierarchy.ANN
{
    public interface Learnable_Supervised : Learnable
    {
        object[][] buildTrainingSet();
        float testTrainingSet(Object[][] trainingSet);


    }
}
