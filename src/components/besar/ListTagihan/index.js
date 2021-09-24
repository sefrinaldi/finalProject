import React from 'react'
import { ScrollView, StyleSheet, Text, View } from 'react-native'
import { CardTagihan } from '../..'
import { colors } from '../../../utils'

const ListTagihan = ({tagihan}) => {
    return (
        <ScrollView showsVerticalScrollIndicator={false}>
            <View style={styles.container}>
                {tagihan.map((tagih, index) => {
                    return <CardTagihan tagih={tagih} key={index} />
                })}
            </View>
        </ScrollView>
    )
}

export default ListTagihan

const styles = StyleSheet.create({
    container: {
       marginTop: 20,
       marginHorizontal: 30 ,
       backgroundColor: colors.white
    }
})
