import React from 'react'
import { ScrollView, StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import { colors } from '../../../utils'

const CardTagihan = ({ tagih }) => {
    return (
        // <ScrollView showsVerticalScrollIndicator={false}>
        <TouchableOpacity style={styles.container}>
            <Text style={styles.title}>Tagihan {tagih.bulan} {tagih.tahun}</Text>

            <View style={styles.desc}>
                <View>
                    <Text>Daya : </Text>
                    <Text>Layanan : </Text>
                    <Text>Status : </Text>
                    <Text style={styles.textBold}>Tagihan</Text>
                </View>
                <View>
                    <Text>{tagih.daya}</Text>
                    <Text>{tagih.layanan}</Text>
                    <Text>{tagih.status}</Text>
                    <Text style={styles.textBold}>{tagih.tagihan}</Text>
                </View>
            </View>
        </TouchableOpacity>
        // </ScrollView>
    )
}

export default CardTagihan

const styles = StyleSheet.create({
    container: {
        marginBottom: 10,
        backgroundColor: colors.white,
        shadowColor: "#000",
        shadowOffset: {
            width: 0,
            height: 2,
        },
        shadowOpacity: 0.25,
        shadowRadius: 3.84,

        elevation: 5,
        padding: 20,
        borderRadius: 10
    },
    title: {
        fontSize: 17,
        fontWeight: 'bold',
        marginBottom: 5
    },
    desc: {
        flexDirection: 'row',
        justifyContent: 'space-between'
    },
    textBold: {
        fontWeight: 'bold'
    }
})
