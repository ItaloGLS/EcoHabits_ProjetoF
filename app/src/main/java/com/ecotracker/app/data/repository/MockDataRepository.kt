package com.ecotracker.app.data.repository

import com.ecotracker.app.data.model.EcoTip

object MockDataRepository {
    
    fun getMockEcoTips(): List<EcoTip> {
        return listOf(
            EcoTip(
                id = 1,
                title = "Economize água no banho",
                description = "Reduza o tempo do banho para 5 minutos e economize até 95 litros de água por dia.",
                category = "Água",
                impactLevel = "Alto",
                difficulty = "Fácil"
            ),
            EcoTip(
                id = 2,
                title = "Use lâmpadas LED",
                description = "Substitua lâmpadas incandescentes por LED e economize até 80% de energia.",
                category = "Energia",
                impactLevel = "Médio",
                difficulty = "Fácil"
            ),
            EcoTip(
                id = 3,
                title = "Separe o lixo reciclável",
                description = "Separe papel, plástico, vidro e metal para facilitar a reciclagem.",
                category = "Reciclagem",
                impactLevel = "Alto",
                difficulty = "Fácil"
            ),
            EcoTip(
                id = 4,
                title = "Use transporte público",
                description = "Prefira transporte público, bicicleta ou caminhada para reduzir emissões.",
                category = "Transporte",
                impactLevel = "Alto",
                difficulty = "Médio"
            ),
            EcoTip(
                id = 5,
                title = "Reutilize sacolas plásticas",
                description = "Use sacolas reutilizáveis ou reutilize as sacolas plásticas que já possui.",
                category = "Resíduos",
                impactLevel = "Médio",
                difficulty = "Fácil"
            ),
            EcoTip(
                id = 6,
                title = "Desligue aparelhos da tomada",
                description = "Desligue completamente aparelhos eletrônicos quando não estiver usando.",
                category = "Energia",
                impactLevel = "Médio",
                difficulty = "Fácil"
            ),
            EcoTip(
                id = 7,
                title = "Colete água da chuva",
                description = "Use a água da chuva para regar plantas e lavar áreas externas.",
                category = "Água",
                impactLevel = "Alto",
                difficulty = "Médio"
            ),
            EcoTip(
                id = 8,
                title = "Faça compostagem",
                description = "Transforme restos orgânicos em adubo natural para plantas.",
                category = "Resíduos",
                impactLevel = "Alto",
                difficulty = "Médio"
            )
        )
    }
    
    fun getDailyTip(): EcoTip {
        return EcoTip(
            id = 999,
            title = "Dica do Dia: Use uma garrafa reutilizável",
            description = "Carregue sempre uma garrafa de água reutilizável para evitar o uso de garrafas plásticas descartáveis. Uma única garrafa reutilizável pode substituir centenas de garrafas plásticas por ano!",
            category = "Resíduos",
            impactLevel = "Alto",
            difficulty = "Fácil"
        )
    }
}
