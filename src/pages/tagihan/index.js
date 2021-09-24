import React, { Component } from 'react'
import { Text, StyleSheet, View } from 'react-native'
import { ListTagihan } from '../../components';
import { dummyTagihan } from '../../data';
import { colors } from '../../utils';

class Tagihan extends Component {
    constructor(props) {
        super(props);
        this.state = {
            tagihan: dummyTagihan
        }
    }
    render() {
        const { tagihan } = this.state
        return (
            <View style={styles.pages}>
                <ListTagihan tagihan={tagihan}/>
            </View>
        );
    }
}

export default Tagihan;

const styles = StyleSheet.create({
    pages: {
        flex: 1,
        backgroundColor: colors.white
    }
})
