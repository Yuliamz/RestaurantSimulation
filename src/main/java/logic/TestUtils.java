package logic;

import java.util.List;

/**
 * @author Yuliamz
 */
public class TestUtils {

    /**
     * Realiza una prueba de K-S
     * @param list lista de números a evaluar
     * @param acceptationGrades grados de aceptación
     * @return true si pasa la prueba, false en caso contrario
     */
    public static boolean testKS(List<Double> list, int acceptationGrades) {
        KolmogorovSmirnov ks = new KolmogorovSmirnov(acceptationGrades, list);
        ks.calculateFinalValue();
        ks.calculateFrequency();
        ks.calculateFrequencyAcumulated();
        ks.calculatedGetProbability();
        ks.calculatedFrequencyExpected();
        ks.calculatedProbabilityExpected();
        ks.calculatedDiference();
        ks.calculatedDMAX();
        ks.calculatedDMAXP();
        return ks.isPseudo();
    }

}
