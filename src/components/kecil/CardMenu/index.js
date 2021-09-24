import React from 'react'
import { StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import { colors } from '../../../utils'

const CardMenu = ({ menu, navigation }) => {
    return (
        <TouchableOpacity
            style={styles.container}
            onPress={() => navigation.navigate(menu.page)}
        >
            <View style={styles.menu}>
                <Text style={styles.text}>{menu.name}</Text>
            </View>
        </TouchableOpacity>
    )
}

export default CardMenu

const styles = StyleSheet.create({
    container: {
        marginTop: 20,
        marginHorizontal: 30,
        backgroundColor: colors.white,
        shadowColor: "#000",
        shadowOffset: {
            width: 0,
            height: 2,
        },
        shadowOpacity: 0.25,
        shadowRadius: 3.84,

        elevation: 5,
        paddingVertical: 15,
        paddingHorizontal: 30,
        borderRadius: 10
    },
    text: {
        fontWeight: 'bold'
    }
})
