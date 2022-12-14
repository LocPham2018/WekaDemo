import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.trees.J48;
import weka.core.*;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;

public class Main {

    public static final String DATASETPATH = "data.arff";
    public static final String MODElPATH = "model.bin";

    public static void main(String[] args) throws Exception {
        ModelGenerator mg = new ModelGenerator();

        Instances dataset = mg.loadDataset(DATASETPATH);

        //Filter filter = new Normalize();

        // divide dataset to train dataset 80% and test dataset 20%
        //int trainSize = (int) Math.round(dataset.numInstances() * 0.8);
        //int testSize = dataset.numInstances() - trainSize;

        //dataset.randomize(new Debug.Random(1));// if you comment this line the accuracy of the model will be droped from 96.6% to 80%

        //Normalize dataset
       // filter.setInputFormat(dataset);
       // Instances datasetnor = Filter.useFilter(dataset, filter);

        //Instances traindataset = new Instances(datasetnor, 0, trainSize);
        //Instances testdataset = new Instances(datasetnor, trainSize, testSize);

        // build classifier with train dataset
//        MultilayerPerceptron ann = (MultilayerPerceptron) mg.buildClassifier(dataset);

        // Evaluate classifier with test dataset
        /*
        String evalsummary = mg.evaluateModel(ann, traindataset, testdataset);
        System.out.println("Evaluation: " + evalsummary);

        //Save model
        mg.saveModel(ann, MODElPATH);

        //classify a single instance
        ModelClassifier cls = new ModelClassifier();
        String classname =cls.classify(Filter.useFilter(cls.createInstance(1.6, 0.2, 0), filter), MODElPATH);
        System.out.println("\n The class name for the instance with petallength = 1.6 and petalwidth =0.2 is  " +classname);
*/

        J48 j48 = new J48();
        j48.buildClassifier(dataset);
        SerializationHelper.write(MODElPATH, j48);

        ModelClassifier cls = new ModelClassifier();
        String[] grade = {"Gioi", "Gioi", "Gioi", "Gioi", "Kha", "Kha", "TB", "Kha"};
        String classname = cls.classify(cls.createInstance(grade), MODElPATH);
        System.out.println(classname);
    }
}