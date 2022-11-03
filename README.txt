English Version :
To compile this project with ant (gui.jar is placed in the lib folder):
ant -f build.xml clean build

If an error shows up, you'll need to change the target and source version value (by default at 7) to your JDK's version.

To run the tests:
ant <NameOfTest>

The available tests are :
TestBalls/TestBallsSimulator/TestBoidSimulator/TestEventManager/TestGoLSimulator/TestGUI/TestImmSimulator/TestPredPreySimulator/TestSchellingSimulator


Version Française :
Pour compiler le projet avec ant (gui.jar est placé dans le dossier lib):
ant -f build.xml clean build

Si il y a une erreur, il faut changer la version de target et source (par défaut à 7) dans build.xml par la version de votre JDK.

Pour lancer les tests :
ant <NomDuTest>

Les différents tests : 
TestBalls/TestBallsSimulator/TestBoidSimulator/TestEventManager/TestGoLSimulator/TestGUI/TestImmSimulator/TestPredPreySimulator/TestSchellingSimulator